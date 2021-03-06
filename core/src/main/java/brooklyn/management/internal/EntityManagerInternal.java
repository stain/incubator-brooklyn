/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package brooklyn.management.internal;

import brooklyn.entity.Application;
import brooklyn.entity.Entity;
import brooklyn.location.Location;
import brooklyn.management.EntityManager;
import brooklyn.management.internal.ManagementTransitionInfo.ManagementTransitionMode;

public interface EntityManagerInternal extends EntityManager {

    /** gets all entities currently known to the application, including entities that are not yet managed */
    Iterable<Entity> getAllEntitiesInApplication(Application application);

    public Iterable<String> getEntityIds();
    
    ManagementTransitionMode getLastManagementTransitionMode(String itemId);
    void setManagementTransitionMode(Entity item, ManagementTransitionMode mode);

    /** 
     * Begins management for the given rebinded root, recursively; 
     * if rebinding as a read-only copy, {@link #setReadOnly(Location, boolean)} should be called prior to this.
     */
    void manageRebindedRoot(Entity item);
    
    void unmanage(final Entity e, final ManagementTransitionMode info);

}
