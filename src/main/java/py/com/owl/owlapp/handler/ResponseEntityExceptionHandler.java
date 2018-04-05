package py.com.owl.owlapp.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import py.com.owl.owlapp.http.ApiResponse;
import py.com.owl.owlapp.validation.ErrorCampo;

@ControllerAdvice
public class ResponseEntityExceptionHandler
		extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

	private Logger logger = Logger.getLogger("Handler");

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		List<ErrorCampo> errorCampoList = new ArrayList<>();
		for (FieldError fieldError : ex.getFieldErrors()) {
			ErrorCampo ec = new ErrorCampo();
			ec.setNombre(fieldError.getField());
			ec.setMessage(fieldError.getDefaultMessage());
			errorCampoList.add(ec);
		}

		ApiResponse<Object> resp = new ApiResponse<>();
		resp.setErrorMsg("Errores de validación");
		resp.setErrores(errorCampoList);
		resp.setData(ex.getTarget());
		return ResponseEntity.badRequest().body(resp);
	}

	// ResponseEntityExceptionHandler Ctrl + Shift + R

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception exc) {
		ApiResponse<Object> resp = new ApiResponse<>();
		resp.setErrorMsg(exc.getMessage());
		// private Logger logger = Logger.getLogger("Handler");

		logger.log(Level.SEVERE, exc.getMessage(), exc);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}

}
