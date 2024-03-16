package authenticationUI;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import authenticationPublisher.AuthenticationInterface;

public class Activator implements BundleActivator {

	//Declare Service Reference
	private ServiceReference<?> authenticationServiceReference;
	
	//Declare Authentication Interface class
	private AuthenticationInterface authenticationService;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Library Main Subscriber Started");
		
		authenticationServiceReference = bundleContext.getServiceReference(AuthenticationInterface.class.getName());
		authenticationService = (AuthenticationInterface) bundleContext.getService(authenticationServiceReference);
		
		AuthenticationUI authenticationUI = new AuthenticationUI(authenticationService);
		authenticationUI.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(authenticationServiceReference);
		
		System.out.println("Library Main Subscriber Stopped");
	}

}
