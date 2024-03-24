//
//  ItemListView.swift
//  TaskTracker
//
//  Created by Sudeep Pratap Kini on 24.03.24.
//

import SwiftUI

struct TaskListView: View {
    var body: some View {
      NavigationView {
        VStack{

        }
        .navigationTitle("Open Items")
        .toolbar {
          Button{

          } label: {
            Image(systemName: "plus")
          }
        }
      }
    }
}

#Preview {
   TaskListView()
}
