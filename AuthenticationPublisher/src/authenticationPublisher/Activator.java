package authenticationPublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @since 1.1
 */
public class Activator implements BundleActivator {

	//Declare service registration
	private ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Authentication Publisher Started");
		
		//register service
		serviceRegistration = bundleContext.registerService(AuthenticationInterface.class.getName(), new AuthenticationImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Book Publisher Stopped");
		serviceRegistration.unregister();
	}

}
