/*
 * Copyright 2008-2009 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package voldemort.client.protocol;

import voldemort.versioning.Versioned;

/**
 * A filter API to provide client a way to filter entries on server side for
 * streaming APIs.<br>
 * Clients can write custom implementation of FilterRequest to implement server
 * side filtering for
 * <ul>
 * <li>
 * {@link AdminClientOLD#deletePartitions(int, String, java.util.List, VoldemortFilter)}
 * </li>
 * <li>
 * {@link AdminClientOLD#fetchPartitionEntries(int, String, java.util.List, VoldemortFilter)}
 * </li>
 * <li>
 * {@link AdminClientOLD#fetchPartitionKeys(int, String, java.util.List, VoldemortFilter)}
 * </li>
 * <li>
 * {@link AdminClientOLD#updateEntries(int, String, java.util.Iterator, VoldemortFilter)}
 * </li>
 * </ul>
 * 
 * <imp> The implementation class maybe transferred over wire and loaded in a
 * different JVM. please make sure to make the class either public or a static
 * inner class so that it can be loaded w/o parent object if needed. </imp>
 * 
 * @author bbansal
 */
public interface VoldemortFilter {

    /**
     * Extend this function to implement custom filter strategies.
     * 
     * @param key
     * @param value
     * @return true: if the pair should be kept.
     */
    public boolean accept(Object key, Versioned<?> value);
}
