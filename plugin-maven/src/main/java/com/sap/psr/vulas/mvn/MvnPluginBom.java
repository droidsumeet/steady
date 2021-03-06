/**
 * This file is part of Eclipse Steady.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.sap.psr.vulas.mvn;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.sap.psr.vulas.goals.BomGoal;
import com.sap.psr.vulas.shared.enums.Scope;
import com.sap.psr.vulas.shared.json.model.Dependency;
import com.sap.psr.vulas.shared.json.model.Library;
import com.sap.psr.vulas.shared.json.model.LibraryId;


/**
 * This Mojo identifies the constructs belonging to the application itself and belonging to all its dependencies.
 * Those are then uploaded to the central Vulas engine for further analysis (test coverage, vulnerability assessments, archive integrity).
 */
@Mojo( name = "app", defaultPhase = LifecyclePhase.TEST, requiresDependencyResolution = ResolutionScope.TEST, requiresOnline = true )
public class MvnPluginBom extends AbstractVulasMojo {
		
	/** {@inheritDoc} */
	@Override
	protected void createGoal() {
		this.goal = new BomGoal();
	}
}
