package junit5.helpers;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.gen5.api.extension.AfterEachExtensionPoint;
import org.junit.gen5.api.extension.ExtensionContext;
import org.junit.gen5.api.extension.MethodInvocationContext;
import org.junit.gen5.api.extension.MethodParameterResolver;
import org.junit.gen5.api.extension.ParameterResolutionException;
import org.junit.gen5.api.extension.TestExtensionContext;

public class TempDirectory implements AfterEachExtensionPoint, MethodParameterResolver {

	private static final String KEY = "tempDirectory";

	@Override
	public boolean supports(Parameter parameter, MethodInvocationContext methodInvocationContext,
			ExtensionContext extensionContext) throws ParameterResolutionException {
		return Path.class.equals(parameter.getType());
	}

	@Override
	public Object resolve(Parameter parameter, MethodInvocationContext methodInvocationContext,
			ExtensionContext context) throws ParameterResolutionException {
		return context.getStore().getOrComputeIfAbsent(KEY, key -> createTempDirectory());
	}

	@Override
	public void afterEach(TestExtensionContext context) throws Exception {
		Path tempDirectory = (Path) context.getStore().get(KEY);
		if (tempDirectory != null) {
			delete(tempDirectory);
		}
	}

	private Path createTempDirectory() {
		try {
			return Files.createTempDirectory("tempDirectory");
		}
		catch (IOException e) {
			throw new ParameterResolutionException("Could not create temp directory", e);
		}
	}

	private void delete(Path tempDirectory) throws IOException {
		Files.walkFileTree(tempDirectory, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				return deleteAndContinue(file);
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				return deleteAndContinue(dir);
			}

			private FileVisitResult deleteAndContinue(Path path) throws IOException {
				Files.delete(path);
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
