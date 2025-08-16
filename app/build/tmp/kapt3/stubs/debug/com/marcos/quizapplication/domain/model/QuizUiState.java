package com.marcos.quizapplication.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003JY\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0006H\u00d6\u0001J\t\u0010*\u001a\u00020\bH\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/marcos/quizapplication/domain/model/QuizUiState;", "", "questions", "", "Lcom/marcos/quizapplication/domain/model/Question;", "currentQuestionIndex", "", "selectedAnswer", "", "userAnswers", "", "score", "isFinished", "", "(Ljava/util/List;ILjava/lang/String;Ljava/util/Map;IZ)V", "currentQuestion", "getCurrentQuestion", "()Lcom/marcos/quizapplication/domain/model/Question;", "getCurrentQuestionIndex", "()I", "()Z", "progress", "", "getProgress", "()F", "getQuestions", "()Ljava/util/List;", "getScore", "getSelectedAnswer", "()Ljava/lang/String;", "getUserAnswers", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class QuizUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.marcos.quizapplication.domain.model.Question> questions = null;
    private final int currentQuestionIndex = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String selectedAnswer = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Integer, java.lang.String> userAnswers = null;
    private final int score = 0;
    private final boolean isFinished = false;
    
    public QuizUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.marcos.quizapplication.domain.model.Question> questions, int currentQuestionIndex, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedAnswer, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, java.lang.String> userAnswers, int score, boolean isFinished) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.marcos.quizapplication.domain.model.Question> getQuestions() {
        return null;
    }
    
    public final int getCurrentQuestionIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedAnswer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.lang.String> getUserAnswers() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    public final boolean isFinished() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.marcos.quizapplication.domain.model.Question getCurrentQuestion() {
        return null;
    }
    
    public final float getProgress() {
        return 0.0F;
    }
    
    public QuizUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.marcos.quizapplication.domain.model.Question> component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.lang.String> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.marcos.quizapplication.domain.model.QuizUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.marcos.quizapplication.domain.model.Question> questions, int currentQuestionIndex, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedAnswer, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, java.lang.String> userAnswers, int score, boolean isFinished) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}