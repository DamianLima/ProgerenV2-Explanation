package com.android.dlddev.progeren2.core.auditorydatabase

import androidx.test.filters.SmallTest
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.ClimateEquipmentDao
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.ClimateEquipmentEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import kotlin.test.Test

@SmallTest
class ClimateEquipmentDaoTest {

    private lateinit var database: AuditoryDatabase
    private lateinit var climateEquipmentDao: ClimateEquipmentDao
    private lateinit var defaultItem: ClimateEquipmentEntity

    @Before
    fun setUp() {
        database = TestDatabase.createDatabase()
        climateEquipmentDao = database.getClimateEquipmentDao()
        defaultItem = ClimateEquipmentEntity(
            id = "equip1",
            linked = "section1",
            name = "Air Conditioner",
            power = 1.0,
            powerCapacity = 10.0,
            quantity = 1,
            cop = 1.0,
            status = "Working",
            comment = "Good condition",
            photos = emptyList(),
            auditor = "John Doe",
            timeStamp = 5L,
            online = true,
            type = "Climate"
        )
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun test01InsertClimateEquipment() = runTest {

        climateEquipmentDao.set(defaultItem)

        val retrieved = climateEquipmentDao.getById("equip1")
        assertThat(retrieved).isEqualTo(defaultItem)
    }

    @Test
    fun test02UpdateClimateEquipment() = runTest {
        climateEquipmentDao.set(defaultItem)

        val updatedEquipment = defaultItem.copy(name = "Updated Heater", power = 2500.0)
        climateEquipmentDao.set(updatedEquipment)

        val retrieved = climateEquipmentDao.getById("equip1")
        assertThat(retrieved).isEqualTo(updatedEquipment)
    }

    @Test
    fun test03InsertAllClimateEquipment() = runTest {
        val equipment2 = ClimateEquipmentEntity(
            id = "equip2",
            linked = "section1",
            name = "Air Conditioner",
            power = 1.0,
            powerCapacity = 10.0,
            quantity = 1,
            cop = 1.0,
            status = "Working",
            comment = "Good condition",
            photos = emptyList(),
            auditor = "John Doe",
            timeStamp = 5L,
            online = true,
            type = "Climate"
        )

        climateEquipmentDao.insertAll(listOf(defaultItem, equipment2))

        val retrievedList = climateEquipmentDao.getAllByLinked("section1").first()
        assertThat(retrievedList).containsExactly(defaultItem, equipment2)
    }

    @Test
    fun test04UpdateAllClimateEquipment() = runTest {
        val equipment2 = ClimateEquipmentEntity(
            id = "equip2",
            linked = "section1",
            name = "Air Conditioner",
            power = 1.0,
            powerCapacity = 10.0,
            quantity = 1,
            cop = 1.0,
            status = "Working",
            comment = "Good condition",
            photos = emptyList(),
            auditor = "John Doe",
            timeStamp = 5L,
            online = true,
            type = "Climate"
        )

        climateEquipmentDao.insertAll(listOf(defaultItem, equipment2))

        val updatedDefaultEquipment = defaultItem.copy(name = "Updated Heater", power = 2500.0)
        val updatedEquipment2 = equipment2.copy(name = "Updated Air Conditioner", power = 1500.0)

        climateEquipmentDao.insertAll(listOf(updatedDefaultEquipment, updatedEquipment2))

        val retrievedList = climateEquipmentDao.getAllByLinked("section1").first()
        assertThat(retrievedList).containsExactly(updatedDefaultEquipment, updatedEquipment2)
    }

    @Test
    fun test05DeleteClimateEquipment() = runTest {
        climateEquipmentDao.set(defaultItem)

        climateEquipmentDao.delete(defaultItem)

        val deleted = climateEquipmentDao.getById("equip1")
        assertThat(deleted).isNull()
    }

    @Test
    fun test06GetAllByLinked() = runTest {
        val equipment2 = ClimateEquipmentEntity(
            id = "equip2",
            linked = "section2",
            name = "Air Conditioner",
            power = 1.0,
            powerCapacity = 10.0,
            quantity = 1,
            cop = 1.0,
            status = "Working",
            comment = "Good condition",
            photos = emptyList(),
            auditor = "John Doe",
            timeStamp = 5L,
            online = true,
            type = "Climate"
        )

        climateEquipmentDao.insertAll(listOf(defaultItem, equipment2))

        val retrievedList = climateEquipmentDao.getAllByLinked("section1").first()
        assertThat(retrievedList).containsExactly(defaultItem)
    }

    @Test
    fun test07GetByLinked() = runTest {
        climateEquipmentDao.set(defaultItem)

        val retrieved = climateEquipmentDao.getByLinked("section1")
        assertThat(retrieved).isEqualTo(defaultItem)
    }
}