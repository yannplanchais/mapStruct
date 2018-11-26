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

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;
import com.mycompany.entities.TargetLombok;
import com.mycompany.entities.TargetLombokSansSpecification;

public class Main {

    public static void main( String[] args ) {
        Source s = new Source();
        s.setTest( "5" );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        System.out.println( t.getTesting() );

        s = new Source();
        s.setTest( "7" );

        TargetLombok tl = SourceTargetMapper.MAPPER.toTargetLombok( s );
        System.out.println( tl.getTesting() );

        new Source();
        s.setTest( "9" );

        TargetLombokSansSpecification tlsp = SourceTargetMapper.MAPPER.toTargetLombokSansSpecification( s );
        System.out.println( tlsp.getTest() );


    }
}