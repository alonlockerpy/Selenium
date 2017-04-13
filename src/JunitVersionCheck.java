import org.junit.Test;

import junit.runner.Version;

public class JunitVersionCheck {
	
	@Test
	public void JUV()
	{
		System.out.println("JUnit version is: " + Version.id());
	}


}
