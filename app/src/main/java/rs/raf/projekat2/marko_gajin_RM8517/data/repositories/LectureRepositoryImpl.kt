package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.LectureDao
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.remote.LectureService
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity

class LectureRepositoryImpl(
    private val localDataSource: LectureDao,
    private val remoteDataSource: LectureService
): LectureRepository {

    override fun fetchAll(): Observable<List<Lecture>> {
        return remoteDataSource
            .getAll()
            .map {
                it.map {
                    Lecture(
                        it.name,
                        it.type,
                        it.professor,
                        it.groups,
                        it.day,
                        it.time,
                        it.classroom
                    )
                }
            }
    }

    override fun insertAll(lectureEntities: List<LectureEntity>): Single<List<Long>> {
        return localDataSource.insertLectures(lectureEntities)
    }

    override fun getAll(): Observable<List<LectureEntity>> {
        return localDataSource.getAll()
    }

}