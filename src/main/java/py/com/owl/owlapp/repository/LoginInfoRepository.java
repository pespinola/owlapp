package py.com.owl.owlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.LoginInfo;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {

}
