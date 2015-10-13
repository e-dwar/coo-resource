package pool;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.NoSuchElementException;

public class ResourcePoolTest {

	@Test(expected=NoSuchElementException.class)
	public void provideResourceTest() {
		ResourcePoolMock pool = new ResourcePoolMock(2);
		assertTrue(pool.provideResource() != null);
		pool.provideResource();
	}

	@Test(expected=IllegalArgumentException.class)
	public void freeResourceTest() {
		ResourcePoolMock pool1 = new ResourcePoolMock(1);
		ResourcePoolMock pool2 = new ResourcePoolMock(1);
		pool1.freeResource(pool2.provideResource());
	}

}
