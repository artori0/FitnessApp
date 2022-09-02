import SwiftUI
import shared

struct Workouts: View {
    var body: some View {
        VStack{
        Image("logo")
            .resizable()
            .aspectRatio(1, contentMode: .fit)
            .frame(width: 100, height: 100, alignment: .center)
        Text("Arms")
        }
    }
}

struct Timer: View {
    var body: some View {
        VStack (alignment: .center){
            Image("logo")
                .resizable()
                .aspectRatio(1, contentMode: .fit)
                .frame(width: 100, height: 100, alignment: .center)
            Text("Timer")
            Spacer()
        }
    }
}

struct CalorieCounter: View {
    var body: some View {
        Text("Calorie Counter")
    }
}

struct Feedback: View {
    @State private var text = ""
    var body: some View {
        VStack (alignment: .center){
            Image("logo")
                .resizable()
                .aspectRatio(1, contentMode: .fit)
                .frame(width: 100, height: 100, alignment: .center)
            Text("Feedback")
                .font(.title)
            CustomTextEditor.init(placeholder:"Enter your feedback here...", text: $text)
                .font(.body)
                .background(Color(UIColor.systemGray5))
                .accentColor(.darkGray)
                .frame(height:400)
                .border(Color.black)
                .padding(5)
            Spacer()
        }
    }
}

struct CustomTextEditor: View {
    let placeholder: String
    @Binding var text: String
    let internalPadding: CGFloat = 5
    
    var body: some View {
        ZStack(alignment: .topLeading) {
            if text.isEmpty {
                Text(placeholder)
                    .foregroundColor(Color.primary.opacity(0.25))
                    .padding(EdgeInsets(top: 7, leading: 4, bottom: 0, trailing:0))
                    .padding(internalPadding)
            }
            TextEditor(text: $text)
                .padding(internalPadding)
        }.onAppear() {
            UITextView.appearance().backgroundColor = .clear
        }.onDisappear() {
            UITextView.appearance().backgroundColor = nil
        }
    }
}

struct Settings: View {
    var body: some View {
        Text("Settings")
    }
}

struct StepCounter: View {
    var body: some View {
        Text("StepCounter")
    }
}

struct Main: View {
    @State private var isShowingWorkout = false
    @State private var isShowingTimer = false
    @State private var isShowingCalorieCounter = false
    @State private var isShowingFeedback = false
    @State private var isShowingSettings = false
    @State private var isShowingStepCounter = false
    
	var body: some View {
        HStack {
            NavigationView {
                VStack (alignment: .center, spacing: 20){
                        Image("logo")
                            .resizable()
                            .aspectRatio(1, contentMode: .fit)
                            .frame(width: 100, height: 100, alignment: .center)
                        Text("Everyday Fitness")
                            .font(.title)
                        Spacer()
                        ProgressView(value: 0.1)
                            .padding(.horizontal,20)
                        Spacer()
                    HStack {
                            Spacer()
                            NavigationLink(destination: Workouts(), isActive: $isShowingWorkout){EmptyView()}
                                Button("Workouts"){
                                    self.isShowingWorkout = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                            NavigationLink(destination: Timer(), isActive: $isShowingTimer){EmptyView()}
                                Button("Timer"){
                                    self.isShowingTimer = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                        }
                        HStack {
                            Spacer()
                            NavigationLink(destination: CalorieCounter(), isActive: $isShowingCalorieCounter){EmptyView()}
                                Button("Calorie Counter"){
                                    self.isShowingCalorieCounter = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                            NavigationLink(destination: StepCounter(), isActive: $isShowingStepCounter){EmptyView()}
                                Button("Step Counter"){
                                    self.isShowingStepCounter = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                    }
                        HStack {
                            Spacer()
                            NavigationLink(destination: Settings(), isActive: $isShowingSettings){EmptyView()}
                                Button("Settings"){
                                    self.isShowingSettings = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                            NavigationLink(destination: Feedback(), isActive: $isShowingFeedback){EmptyView()}
                                Button("Feedback"){
                                    self.isShowingFeedback = true
                                    }
                                    .frame(width: 150, height: 75)
                                    .foregroundColor(Color.black)
                                    .background(Color.lightGray)
                                    .cornerRadius(10)
                            Spacer()
                    }
                        Spacer()
                    }
                Spacer()
            }
        }
        }
    }

struct Previews: PreviewProvider {
    static var previews: some View {
        Main()
        Feedback()
	}
}
