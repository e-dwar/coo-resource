package pool;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool {

    protected ArrayList<Resource> freeResources;
    protected ArrayList<Resource> busyResources;
    protected abstract Resource createResource();
    
    public ResourcePool(int nResources) {
        freeResources = new ArrayList<Resource>();
        busyResources = new ArrayList<Resource>(); 
        while ((nResources--) > 0) {
            freeResources.add(this.createResource());
        }
    }

    public Resource provideResource() {
        if (this.freeResources.size() == 0) {
            throw new NoSuchElementException();
        }
        else {
            Resource resource = this.freeResources.remove(0);
            this.busyResources.add(resource);
            return resource;
        }
    }
    
    public void freeResource(Resource resource) {
        if (!this.busyResources.remove(resource)) {
            throw new IllegalArgumentException();
        }
        else {
            this.freeResources.add(resource);
        }
    }
}
