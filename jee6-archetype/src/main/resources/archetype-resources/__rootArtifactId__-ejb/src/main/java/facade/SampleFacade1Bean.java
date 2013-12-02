#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.facade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import ${package}.business.SampleBusiness1;
import ${package}.dto.SampleDTO1;

@Stateless
@Local(value=SampleFacade1.class)
public class SampleFacade1Bean implements SampleFacade1 {
	
	@EJB
	SampleBusiness1 business1;
	
	public SampleDTO1 sampleMethod1(SampleDTO1 dto) {
		business1.businessMethod1();
		business1.businessMethod2();

		return new SampleDTO1();
	}

}
