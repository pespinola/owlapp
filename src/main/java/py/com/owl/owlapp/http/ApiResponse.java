package py.com.owl.owlapp.http;

import java.util.List;

import py.com.owl.owlapp.validation.ErrorCampo;

public class ApiResponse<T> {
	private T data;
	private String errorMsg;
	private List<ErrorCampo> errores;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<ErrorCampo> getErrores() {
		return errores;
	}

	public void setErrores(List<ErrorCampo> errores) {
		this.errores = errores;
	}
}
