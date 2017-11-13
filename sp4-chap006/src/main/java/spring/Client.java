package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String host;

	public void setHost(String host) {
		this.host = host;
		System.out.println("Client.setHost() 실행");
	}

	public void send() {
		System.out.println("Client.send() to " + host);
	}


	//빈 객체가 소멸할때  DisposableBean 클래스를 구현
	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destroy() 실행");
	}


	//빈 객체가 생성되고 초기화 할 InitialzingBean 클래스를 구현
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
	}

}
