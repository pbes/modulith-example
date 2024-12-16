package hu.pbes.blog.modulithexample;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModulesTest {

    @Test
    public void testModuleStructure() {
        final var modules = ApplicationModules.of(ModulithExampleApplication.class);
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
