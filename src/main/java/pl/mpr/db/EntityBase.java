package pl.mpr.db;

public abstract class EntityBase {
    
    protected int id;

    protected EntityOperation operation = EntityOperation.none;
    
    public int getId() {
            return id;
    }

    //public void setId(int index) {
            
   // }

    public EntityOperation getOperation() {
            return operation;
    }

    public void setOperation(EntityOperation operation) {
            this.operation = operation;
    }

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	
    
}

