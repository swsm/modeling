package AbstractFactoryPattern.S3;

public interface IFactory {
    public IUser createUser();
    public IDepartment createDepartment();
}
