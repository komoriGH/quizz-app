package com.marcos.quizapplication.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aO\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0007\u001a\b\u0010\u0014\u001a\u00020\tH\u0007\u001a\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0007\u001a\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0006H\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\u001a"}, d2 = {"sampleQuizzes", "", "Lcom/marcos/quizapplication/ui/screens/Quiz;", "getSampleQuizzes", "()Ljava/util/List;", "sampleStats", "Lcom/marcos/quizapplication/ui/screens/Stat;", "getSampleStats", "HomeScreen", "", "userName", "", "onLogout", "Lkotlin/Function0;", "onStartQuizClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "quizId", "onProfileClick", "HomeScreenPreview", "QuizCard", "quiz", "onStartClick", "StatCard", "stat", "app_debug"})
public final class HomeScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.marcos.quizapplication.ui.screens.Stat> sampleStats = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.marcos.quizapplication.ui.screens.Quiz> sampleQuizzes = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.marcos.quizapplication.ui.screens.Stat> getSampleStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.marcos.quizapplication.ui.screens.Quiz> getSampleQuizzes() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onStartQuizClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onProfileClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatCard(@org.jetbrains.annotations.NotNull()
    com.marcos.quizapplication.ui.screens.Stat stat) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuizCard(@org.jetbrains.annotations.NotNull()
    com.marcos.quizapplication.ui.screens.Quiz quiz, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStartClick) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, name = "Home Screen Preview")
    @androidx.compose.runtime.Composable()
    public static final void HomeScreenPreview() {
    }
}