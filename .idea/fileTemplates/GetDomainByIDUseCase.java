#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

public abstract class Get${Domain}ByIDUseCase
    extends UseCase<String, Get${Domain}ByIDOutput> {
}