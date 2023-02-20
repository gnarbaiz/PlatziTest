package platzi.gnarbaiz.testapp.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import platzi.gnarbaiz.testapp.domain.usecase.CharactersUseCase
import platzi.gnarbaiz.testapp.domain.usecase.CharactersUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindCharacterUseCase(useCaseImpl: CharactersUseCaseImpl): CharactersUseCase
}