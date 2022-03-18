import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void simpleTestVerify(){
        verify(dependency, never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
        verify(dependency, times(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
        verify(dependency, atLeast(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
        verify(dependency, atMost(3)).getClassNameUpperCase();

    }

    @Test
    public void verifyParameters(){
        dependency.addTwo(5);
        verify(dependency, times(1)).addTwo(5);
        dependency.addTwo(5);
        verify(dependency, times(2)).addTwo(anyInt());

    }

    @Test
    public void testAddTwoAny(){
        when(dependency.addTwo(anyInt())).thenReturn(0);

        assertEquals(0, dependency.addTwo(3));
        assertEquals(0, dependency.addTwo(80));
    }

    @Test
    public void testAddTwo(){
        when(dependency.addTwo(1)).thenReturn(5);

        assertEquals(5, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));
    }
}
