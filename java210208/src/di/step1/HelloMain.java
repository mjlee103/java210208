package di.step1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/*
 * spirng-core.jar는 IoC를 제공하는 역할
 * IoC는 Inversion of Coversion의 약자 임 - 역제어 또는 제어 역행을 뜻함.
 * 최근에 사용되는 모든 컨테이너들이 공통적으로 사용하는 개념
 * <기존방식>
 * 자바 기반으로 어플리케이션을 개발 할 때 자바 객체를 생성하고 서로간의 의존관계를 연결시킬 때
 * 작업에 대한 제어권은 코퐁 개발되는 어플리케이션에 있었음. 
 * 
 * <문제 제기>
 * 컴포넌트간의 결합도가 높아서 컴포넌트의 확장 및 재사용이 어려운 문제 발생.
 * 
 * <해결방법>
 * IoC 사용
 * 제어권이 Container에게 넘어가 객체의 생명 주기를 Container를 전담하게 됨.
 * 
 * <해결내용>
 * 컴포넌트 간의 결합도가 낮아져 컴포넌트의 재사용 및 확장이 쉽고
 * 컴포넌트 간의 의존관계 변경이 쉬움. 
 */

public class HelloMain {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext는 ApplicationContest의 구현체 클래스임.
		//생성자 파라미터로 xml 문서를 스캔함. 
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
									("di\\step1\\helloBean.xml");	
		ApplicationContext context2 = 
				new ClassPathXmlApplicationContext
				("di\\step1\\sonataBean.xml");	
		Sonata himCar = (Sonata)context2.getBean("himCar");
		Sonata herCar = (Sonata)context2.getBean("herCar");
		System.out.println(himCar);
		System.out.println(herCar);
		Resource resource = new FileSystemResource("C:\\git_java210208\\java210208\\java210208\\src\\di\\step1\\helloBean.xml"); //filesystemresource는 전체 경로를 적어야만이 파일 확인 가능
		BeanFactory factory = new XmlBeanFactory(resource);
		HelloBean helloBean2 = (HelloBean)factory.getBean("helloBean222");
		HelloBean helloBean = (HelloBean)context.getBean("helloBean222");
		System.out.println(helloBean.getGreeting("Hi~"));
		System.out.println(helloBean.getGreeting("Hi~"));


	}

}
