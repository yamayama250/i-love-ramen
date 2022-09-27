package local.hal.st42.android.originalapp90014.features.ramen.repository

import kotlinx.coroutines.flow.Flow
import local.hal.st42.android.originalapp90014.database.RamenDAO
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen

interface RamenRepository {
    val ramenList: Flow<List<Ramen>>
    fun findById(id: Int): Flow<Ramen>
    fun insertRamen(ramen: Ramen)
    fun updateRamen(ramen: Ramen)
    fun deleteRamen(ramen: Ramen)
}

class RamenRepositoryImpl(
    private val ramenDAO: RamenDAO
): RamenRepository {
    override val ramenList: Flow<List<Ramen>>
        = ramenDAO.getAll()

    override fun findById(id: Int): Flow<Ramen> {
        return ramenDAO.findById(id)
    }

    override fun insertRamen(ramen: Ramen) {
        ramenDAO.insertRamen(ramen)
    }

    override fun updateRamen(ramen: Ramen) {
        ramenDAO.updateRamen(ramen)
    }

    override fun deleteRamen(ramen: Ramen) {
        ramenDAO.deleteRamen(ramen)
    }
}