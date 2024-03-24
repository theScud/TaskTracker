//
//  TaskProtocol.swift
//  TaskTracker
//
//  Created by Sudeep Pratap Kini on 24.03.24.
//

import Foundation

enum TaskState: String {
  case notStated
  case onGoing
  case completed
}

extension TaskState: Codable {}

//protocol Task {
//  var id: UUID { get }
//  var shortDescription: String { get set }
//  var detailedDescription:String { get set }
//  var state: TaskState { get }
//
//  func completed()
//}

