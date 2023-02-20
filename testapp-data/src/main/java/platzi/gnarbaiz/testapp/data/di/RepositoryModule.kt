package platzi.gnarbaiz.testapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import platzi.gnarbaiz.testapp.data.repository.CharsRepositoryImpl
import platzi.gnarbaiz.testapp.domain.repository.CharsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindCharsRepository(repository: CharsRepositoryImpl): CharsRepository
}