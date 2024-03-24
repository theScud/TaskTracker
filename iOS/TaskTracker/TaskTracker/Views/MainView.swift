//
//  ContentView.swift
//  TaskTracker
//
//  Created by Sudeep Pratap Kini on 24.03.24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
      TabView{
        TaskListView()
          .tabItem {
            Label("TODO", systemImage: "checklist.unchecked")
          }
        TaskListView()
          .tabItem {
            Label("Completed",
                  systemImage: "checklist.checked")
          }
      }
    }
}

#Preview {
    ContentView()
}
