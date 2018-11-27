/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mycompany.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.mycompany.dto.SourceAvecAttributObjet;
import com.mycompany.entities.TargetLombok;
import com.mycompany.entities.TargetLombokAvecAttributObjet;
import com.mycompany.entities.TargetLombokAvecAttributObjetNomDifferent;
import com.mycompany.entities.TargetLombokAvecAttributObjetNomDifferentTotal;
import com.mycompany.entities.TargetLombokSansSpecification;
import org.junit.Test;

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;

public class SourceTargetMapperTest {

    @Test
    public void testMapping() {

        // 1] Test de mapping simple => 1 champ texte donne un champ Long
        Source s = new Source();
        s.setTest( "5" );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        assertEquals("On attend la valeur de l'attribut", 5, (long) t.getTesting() );

        // 2] Test de mapping en utilisant la bibliothèque Lombok
        // toujours 1 champ texte donne un champ Long
        s = new Source();
        s.setTest( "7" );
        TargetLombok tl = SourceTargetMapper.MAPPER.toTargetLombok( s );
        System.out.println( tl.getTesting() );
        assertEquals("On attend la valeur de l'attribut", 7, (long) tl.getTesting() );


        // 3] Test de mapping sans utiliser les annotations
        new Source();
        s.setTest( "9" );

        TargetLombokSansSpecification tlsp = SourceTargetMapper.MAPPER.toTargetLombokSansSpecification( s );
        System.out.println( tlsp.getTest() );
        assertEquals("On attend la valeur de l'attribut", 9, (long) tlsp.getTest() );

        // 4] Test de mapping avec le mapping d'un attribut qui se trouve être un objet.
        SourceAvecAttributObjet saao = new SourceAvecAttributObjet();
        saao.setSourceAvecObjet(s);
        saao.setTestAvecObjet("3");
        TargetLombokAvecAttributObjet tlaao = SourceTargetMapper.MAPPER.toTargetLombokAvecAttributObjet(saao);
        assertEquals("On attend la valeur de l'attribut", 3, (long) tlaao.getTestAvecObjet() );
        assertNotNull("L'objet ne doit pas être nul", tlaao.getSourceAvecObjet());
        assertEquals("On attend la valeur de l'attribut dans l'objet", 9L, (long) tlaao.getSourceAvecObjet().getTest() );
        System.out.println(tlaao.getSourceAvecObjet());
        System.out.println(tlaao.getTestAvecObjet());

        // 5] Test de mapping avec le mapping d'un attribut qui se trouve être un objet Avec des noms différents.
        SourceAvecAttributObjet saaoNomDifferent = new SourceAvecAttributObjet();
        saao.setSourceAvecObjet(s);
        saao.setTestAvecObjet("12");
        TargetLombokAvecAttributObjetNomDifferent tlaaoNomDiff = SourceTargetMapper.MAPPER.toTargetLombokAvecAttributObjetNomDifferent(saao);
        System.out.println(tlaaoNomDiff.getTestAvecObjetNomDifferent());
        System.out.println(tlaaoNomDiff.getSourceAvecObjetNomDifferent());
        assertEquals("On attend la valeur de l'attribut", 12, (long) tlaaoNomDiff.getTestAvecObjetNomDifferent() );
        assertNotNull("L'objet ne doit pas être nul", tlaaoNomDiff.getSourceAvecObjetNomDifferent());
        assertEquals("On attend la valeur de l'attribut dans l'objet", 9L, (long) tlaaoNomDiff.getSourceAvecObjetNomDifferent().getTest() );

        // 5] Test de mapping avec tous les noms d'attributs sont différents.
        saaoNomDifferent = new SourceAvecAttributObjet();
        saao.setSourceAvecObjet(s);
        saao.setTestAvecObjet("14");
        TargetLombokAvecAttributObjetNomDifferentTotal tlaaoNomDiffTotal = SourceTargetMapper.MAPPER.toTargetLombokAvecAttributObjetNomDifferentTotal(saao);
        System.out.println(tlaaoNomDiffTotal.getTestAvecObjetNomDifferentTotal());
        System.out.println(tlaaoNomDiffTotal.getSourceAvecObjetNomDifferentTotal());

        assertEquals("On attend la valeur de l'attribut",14, (long) tlaaoNomDiffTotal.getTestAvecObjetNomDifferentTotal() );
        assertNotNull("L'objet ne doit pas être nul", tlaaoNomDiffTotal.getSourceAvecObjetNomDifferentTotal());
        assertEquals("On attend la valeur de l'attribut dans l'objet", 9L, (long) tlaaoNomDiffTotal.getSourceAvecObjetNomDifferentTotal().getTesting() );

    }
}
