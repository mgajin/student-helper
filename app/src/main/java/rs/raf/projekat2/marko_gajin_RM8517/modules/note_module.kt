package rs.raf.projekat2.marko_gajin_RM8517.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.Database
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.NoteRepository
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.NoteRepositoryImpl
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.NoteViewModel

val noteModule = module {

    viewModel { NoteViewModel(get()) }

    single<NoteRepository> { NoteRepositoryImpl(get()) }

    single { get<Database>().getNoteDao() }
    
}