
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DependencyTest {

    @Mock
    private SubDependency subDependency;

    private Dependency dependency;

    @BeforeEach
    void setUp() {

        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    void SubdependencyTest() {
        when(subDependency.getClassName()).thenReturn("Hi there, how are you?");

       assertEquals("Hi there, how are you?", dependency.getSubdepedencyClassName());
    }




}

