package com.marcos.quizapplication.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007\u001a,\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a@\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0007\u00a8\u0006\u001a"}, d2 = {"AnswerOption", "", "text", "", "isSelected", "", "onOptionSelected", "Lkotlin/Function0;", "QuizHeader", "progress", "", "questionNumber", "", "totalQuestions", "QuizRoute", "viewModel", "Lcom/marcos/quizapplication/ui/viewmodel/QuizViewModel;", "onNavigateBack", "onNavigateHome", "QuizScreen", "uiState", "Lcom/marcos/quizapplication/domain/model/QuizUiState;", "onAnswerSelected", "Lkotlin/Function1;", "onNextClicked", "QuizScreenPreview", "app_debug"})
public final class QuizzScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void QuizRoute(@org.jetbrains.annotations.NotNull()
    com.marcos.quizapplication.ui.viewmodel.QuizViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateHome) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void QuizScreen(com.marcos.quizapplication.domain.model.QuizUiState uiState, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAnswerSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onNextClicked, kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuizHeader(float progress, int questionNumber, int totalQuestions) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AnswerOption(@org.jetbrains.annotations.NotNull()
    java.lang.String text, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOptionSelected) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void QuizScreenPreview() {
    }
}