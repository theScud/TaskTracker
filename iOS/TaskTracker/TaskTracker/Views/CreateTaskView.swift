//
//  CreateTaskView.swift
//  TaskTracker
//
//  Created by Sudeep Pratap Kini on 24.03.24.
//

import SwiftUI

struct CreateTaskView: View {
    var body: some View {
      VStack {
        Text("New Item")
          .bold()
          .font(.system(size: 32))

        Form {
          TextField()
        }

      }
    }
}

#Preview {
    CreateTaskView()
}
