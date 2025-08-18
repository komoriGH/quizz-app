package com.marcos.quizapplication.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/marcos/quizapplication/ui/viewmodel/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/marcos/quizapplication/domain/contracts/AuthRepository;", "(Lcom/marcos/quizapplication/domain/contracts/AuthRepository;)V", "_profileUpdateState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/marcos/quizapplication/ui/viewmodel/ProfileUpdateState;", "_userState", "Lcom/marcos/quizapplication/domain/model/User;", "profileUpdateState", "Lkotlinx/coroutines/flow/StateFlow;", "getProfileUpdateState", "()Lkotlinx/coroutines/flow/StateFlow;", "userState", "getUserState", "observeAuthState", "", "resetProfileUpdateState", "updateProfilePicture", "imageUri", "Landroid/net/Uri;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.marcos.quizapplication.domain.contracts.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.marcos.quizapplication.domain.model.User> _userState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.domain.model.User> userState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.marcos.quizapplication.ui.viewmodel.ProfileUpdateState> _profileUpdateState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.ui.viewmodel.ProfileUpdateState> profileUpdateState = null;
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    com.marcos.quizapplication.domain.contracts.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.domain.model.User> getUserState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.ui.viewmodel.ProfileUpdateState> getProfileUpdateState() {
        return null;
    }
    
    private final void observeAuthState() {
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri) {
    }
    
    public final void resetProfileUpdateState() {
    }
}