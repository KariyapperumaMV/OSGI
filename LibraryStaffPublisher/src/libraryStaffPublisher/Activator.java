package libraryStaffPublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @since 1.1
 */
public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Library Staff Publisher Started");
		
		//register service
		serviceRegistration = bundleContext.registerService(ILibraryStaff.class.getName(), new LibraryStaffImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Library Member Publisher Stopped");
		serviceRegistration.unregister();
	}

}
