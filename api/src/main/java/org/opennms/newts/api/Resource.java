/*
 * Copyright 2014, The OpenNMS Group
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opennms.newts.api;


import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.base.Optional;


/**
 * A unique resource to associate a group of metrics to. Newts utilizes this structure to index the
 * resources of the samples it has seen, providing a means of search and discovery.
 * 
 * @author eevans
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = -7061059766465651705L;

    private final String m_id;
    private final Optional<Map<String, String>> m_attributes;

    /**
     * Creates a new {@link Resource} instance with the supplied resource ID, default application
     * ID, and an empty set of attributes.
     *
     * @param id
     *            the resource identifier.
     */
    public Resource(String id) {
        this(id, Optional.<Map<String, String>>absent());
    }

    /**
     * Creates a new {@link Resource} with the supplied ID.
     *
     * @param id
     *            resource identifier.
     * @param attributes
     *            attributes to associate with this resource.
     */
    public Resource(String id, Optional<Map<String, String>> attributes) {
        m_id = checkNotNull(id, "id argument");
        m_attributes = checkNotNull(attributes, "attributes argument");
    }

    /**
     * @return the ID of this resource.
     */
    public String getId() {
        return m_id;
    }

    /**
     * @return the set of attributes for this resource.
     */
    public Optional<Map<String, String>> getAttributes() {
        return m_attributes;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getAttributes());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Resource)) return false;
        return getId().equals(((Resource) o).getId());
    }

}
