package com.mycompany.mapper;

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;
import com.mycompany.entities.TargetLombok;
import com.mycompany.entities.TargetLombokSansSpecification;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-26T11:36:16+0100",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 10.0.2 (Oracle Corporation)"
)
public class SourceTargetMapperImpl implements SourceTargetMapper {

    @Override
    public Target toTarget(Source s) {
        if ( s == null ) {
            return null;
        }

        Target target = new Target();

        if ( s.getTest() != null ) {
            target.setTesting( Long.parseLong( s.getTest() ) );
        }

        return target;
    }

    @Override
    public TargetLombok toTargetLombok(Source s) {
        if ( s == null ) {
            return null;
        }

        TargetLombok targetLombok = new TargetLombok();

        if ( s.getTest() != null ) {
            targetLombok.setTesting( Long.parseLong( s.getTest() ) );
        }

        return targetLombok;
    }

    @Override
    public TargetLombokSansSpecification toTargetLombokSansSpecification(Source s) {
        if ( s == null ) {
            return null;
        }

        TargetLombokSansSpecification targetLombokSansSpecification = new TargetLombokSansSpecification();

        if ( s.getTest() != null ) {
            targetLombokSansSpecification.setTest( Long.parseLong( s.getTest() ) );
        }

        return targetLombokSansSpecification;
    }
}
