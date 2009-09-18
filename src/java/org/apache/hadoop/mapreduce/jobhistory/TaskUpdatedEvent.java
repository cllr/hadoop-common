/**
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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.mapreduce.jobhistory;

import java.io.IOException;

import org.apache.hadoop.mapreduce.TaskID;

import org.apache.avro.util.Utf8;

/**
 * Event to record updates to a task
 *
 */
public class TaskUpdatedEvent implements HistoryEvent {
  private Events.TaskUpdated datum = new Events.TaskUpdated();

  /**
   * Create an event to record task updates
   * @param id Id of the task
   * @param finishTime Finish time of the task
   */
  public TaskUpdatedEvent(TaskID id, long finishTime) {
    datum.taskid = new Utf8(id.toString());
    datum.finishTime = finishTime;
  }

  TaskUpdatedEvent() {}

  public Object getDatum() { return datum; }
  public void setDatum(Object datum) { this.datum = (Events.TaskUpdated)datum; }

  /** Get the task ID */
  public TaskID getTaskId() { return TaskID.forName(datum.taskid.toString()); }
  /** Get the task finish time */
  public long getFinishTime() { return datum.finishTime; }
  /** Get the event type */
  public Events.EventType getEventType() {
    return Events.EventType.TASK_UPDATED;
  }

}
