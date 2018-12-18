package com.mycompany.mapper;

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;
import org.mapstruct.Named;

@Named("MapperTarget")
public class TargetEmptyMapper {

  @Named("toSource")
  public Source asSource(Target target) {
    Source retour = null;
    if (target != null && "CONSTANTE_OK".equals(target.getConstante())) {
      retour = new Source();
      retour.setTest("TestOK");
    }
    return retour;
  }

  @Named("toTarget")
  public Target asTarget(Source source) {
    Target retour = null;
    if (source != null && "12345".equals(source.getTest())) {
      retour = new Target();
      retour.setConstante("CONSTANTE_OK");
      retour.setTesting(12345L);
    }

    return retour;
  }

}
