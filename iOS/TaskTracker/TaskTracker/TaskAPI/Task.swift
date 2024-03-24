//
//  Task.swift
//  TaskTracker
//
//  Created by Sudeep Pratap Kini on 24.03.24.
//

import Foundation
import SwiftData

@Model
class Task {
  @Attribute(.unique) var id: UUID
  var shortDescription: String
  var detailedDescription: String
  var createdAt: Date
  var state: TaskState

  @Relationship(deleteRule: .cascade) var timeSlices: [TimeSlice]

  init(id: UUID, shortDescription: String, detailedDescription: String, createdAt: Date, state: TaskState, timeSlices: [TimeSlice] = []) {
    self.id = id
    self.shortDescription = shortDescription
    self.detailedDescription = detailedDescription
    self.createdAt = createdAt
    self.state = state
    self.timeSlices = timeSlices
  }
}

extension Task: Identifiable {}

@Model
class TimeSlice {
  @Attribute(.unique) var id: UUID
  var start: Date
  var end: Date

  init(id: UUID, start: Date, end: Date) {
    self.id = id
    self.start = start
    self.end = end
  }
}

extension TimeSlice: Identifiable {}

extension TimeSlice: Hashable {}


