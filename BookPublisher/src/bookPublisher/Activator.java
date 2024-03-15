package bookPublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	//Declare service registration
	private ServiceRegistration<?> serviceRegistration;

	//Start method
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Book Publisher Started");
		
		//register service
		serviceRegistration = bundleContext.registerService(IBook.class.getName(), new BookImpl(), null);
	}

	// Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Authentication Publisher Stopped");
		serviceRegistration.unregister();
	}

}
