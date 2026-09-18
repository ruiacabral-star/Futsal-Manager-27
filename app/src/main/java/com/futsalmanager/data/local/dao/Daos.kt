package com.futsalmanager.data.local.dao

import androidx.room.*
import com.futsalmanager.data.local.entity.ClubEntity
import com.futsalmanager.data.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubDao {
    @Query("SELECT * FROM clubs WHERE id = :clubId")
    fun getClubById(clubId: String): Flow<ClubEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateClub(club: ClubEntity)
}

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players WHERE clubId = :clubId")
    fun getPlayersByClub(clubId: String): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<PlayerEntity>)
}
