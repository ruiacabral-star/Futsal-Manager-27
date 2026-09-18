package com.futsalmanager.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity(
    @PrimaryKey val id: String,
    val name: String,
    val balance: Double,
    val monthlyIncome: Double,
    val monthlyExpenses: Double,
    val stadiumCapacity: Int,
    val ticketPrice: Double,
    val reputation: Int
)

@Entity(
    tableName = "players",
    foreignKeys = [
        ForeignKey(
            entity = ClubEntity::class,
            parentColumns = ["id"],
            childColumns = ["clubId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("clubId")]
)
data class PlayerEntity(
    @PrimaryKey val id: String,
    val clubId: String,
    val name: String,
    val position: String,
    val overall: Int,
    val fatigue: Int,
    val progressPercent: Float,
    val specificFocus: String,
    val estimatedValue: Double,
    val salary: Double,
    val contractYears: Int,
    val scoutingProgress: Int
)
