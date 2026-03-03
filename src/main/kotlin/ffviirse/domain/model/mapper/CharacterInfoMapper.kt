package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.CharacterInfo
import ffviirse.domain.model.entity.PartyInfo
import ffviirse.domain.model.value.PartyMember
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import java.nio.ByteBuffer

fun ByteBuffer.partyInfo(bytes: ByteArray): PartyInfo = PartyInfo(
    cloudStrife = this.characterData(CLOUD_STRIFE, bytes),
    barretWallace = this.characterData(BARRET_WALLACE, bytes),
    tifaLockhart = this.characterData(TIFA_LOCKHART, bytes),
    aerithGainsborough = this.characterData(AERITH_GAINSBOROUGH, bytes),
    redXiii = this.characterData(RED_XIII, bytes),
    yuffieKisaragi = this.characterData(YUFFIE_KISARAGI, bytes),
    caitSith = this.characterData(CAIT_SITH, bytes),
)

fun ByteBuffer.characterData(
    member: PartyMember,
    bytes: ByteArray,
): CharacterInfo = this.let { buffer ->
    val characterOffset = member.fileIndex * characterBaseOffset

    val weaponMaterias = (0 until 8).map { i ->
        buffer.getInt(characterOffset + weaponMateriaOffset + i * 4)
    }
    val armorMaterias = (0 until 8).map { i ->
        buffer.getInt(characterOffset + armorMateriaOffset + i * 4)
    }

    CharacterInfo(
        characterMember = member,
        characterLevel = buffer.get(characterOffset + characterLevelOffset).toInt() and 0xFF,
        characterExperience = buffer.getInt(characterOffset + characterExperienceOffset),
        characterRelationship = 0.takeIf { !member.hasRelationship } ?: buffer.getInt(characterOffset + characterRelationshipOffset),
        characterHpcurrent = buffer.getInt(characterOffset + characterHpcurrentOffset),
        characterHpmax = buffer.getInt(characterOffset + characterHpmaxOffset),
        characterMpcurrent = buffer.getInt(characterOffset + characterMpcurrentOffset),
        characterMpmax = buffer.getInt(characterOffset + characterMpmaxOffset),
        characterAttack = buffer.getInt(characterOffset + characterAttackOffset),
        characterMattack = buffer.getInt(characterOffset + characterMattackOffset),
        characterDefense = buffer.getInt(characterOffset + characterDefenseOffset),
        characterMdefense = buffer.getInt(characterOffset + characterMdefenseOffset),
        characterStrength = buffer.getInt(characterOffset + characterStrengthOffset),
        characterMagic = buffer.getInt(characterOffset + characterMagicOffset),
        characterVitality = buffer.getInt(characterOffset + characterVitalityOffset),
        characterSpirit = buffer.getInt(characterOffset + characterSpiritOffset),
        characterLuck = buffer.getInt(characterOffset + characterLuckOffset),
        characterSpeed = buffer.getInt(characterOffset + characterSpeedOffset),
        criticalHrate = buffer.getInt(characterOffset + criticalHrateOffset),
        weaponLevel = buffer.getInt(characterOffset + weaponLevelOffset),
        characterWeapon = buffer.getInt(characterOffset + characterWeaponOffset),
        characterArmor = buffer.getInt(characterOffset + characterArmorOffset),
        characterSummon = buffer.getInt(characterOffset + characterSummonOffset),
        characterAccessory = buffer.getInt(characterOffset + characterAccessoryOffset),
        statBoost01 = bytes.isBitSet(member.statBoost01Offset, member.statBoost01Bit),
        statBoost02 = bytes.isBitSet(member.statBoost02Offset, member.statBoost02Bit),
        statBoost03 = bytes.isBitSet(member.statBoost03Offset, member.statBoost03Bit),
        statBoost04 = bytes.isBitSet(member.statBoost04Offset, member.statBoost04Bit),
        statBoost05 = bytes.isBitSet(member.statBoost05Offset, member.statBoost05Bit),
        statBoost06 = bytes.isBitSet(member.statBoost06Offset, member.statBoost06Bit),
        statBoost07 = bytes.isBitSet(member.statBoost07Offset, member.statBoost07Bit),
        statBoost08 = bytes.isBitSet(member.statBoost08Offset, member.statBoost08Bit),
        statBoost09 = bytes.isBitSet(member.statBoost09Offset, member.statBoost09Bit),
        statBoost10 = bytes.isBitSet(member.statBoost10Offset, member.statBoost10Bit),
        statBoost11 = bytes.isBitSet(member.statBoost11Offset, member.statBoost11Bit),
        statBoost12 = bytes.isBitSet(member.statBoost12Offset, member.statBoost12Bit),
        statBoost13 = bytes.isBitSet(member.statBoost13Offset, member.statBoost13Bit),
        statBoost14 = bytes.isBitSet(member.statBoost14Offset, member.statBoost14Bit),
        statBoost15 = bytes.isBitSet(member.statBoost15Offset, member.statBoost15Bit),
        statBoost16 = bytes.isBitSet(member.statBoost16Offset, member.statBoost16Bit),
        statBoost17 = bytes.isBitSet(member.statBoost17Offset, member.statBoost17Bit),
        statBoost18 = bytes.isBitSet(member.statBoost18Offset, member.statBoost18Bit),
        statBoost19 = bytes.isBitSet(member.statBoost19Offset, member.statBoost19Bit),
        limitBreak = bytes.isBitSet(member.limitBreakOffset, member.limitBreakBit),
        characterAbility01 = bytes.isBitSet(member.characterAbility01Offset, member.characterAbility01Bit),
        characterAbility02 = bytes.isBitSet(member.characterAbility02Offset, member.characterAbility02Bit),
        characterAbility03 = bytes.isBitSet(member.characterAbility03Offset, member.characterAbility03Bit),
        characterAbility04 = bytes.isBitSet(member.characterAbility04Offset, member.characterAbility04Bit),
        characterAbility05 = bytes.isBitSet(member.characterAbility05Offset, member.characterAbility05Bit),
        synergySkill01 = bytes.isBitSet(member.synergySkill01Offset, member.synergySkill01Bit),
        synergySkill02 = bytes.isBitSet(member.synergySkill02Offset, member.synergySkill02Bit),
        synergySkill03 = bytes.isBitSet(member.synergySkill03Offset, member.synergySkill03Bit),
        synergyAbility01 = bytes.isBitSet(member.synergyAbility01Offset, member.synergyAbility01Bit),
        synergyAbility02 = bytes.isBitSet(member.synergyAbility02Offset, member.synergyAbility02Bit),
        synergyAbility03 = bytes.isBitSet(member.synergyAbility03Offset, member.synergyAbility03Bit),
        synergyAbility04 = bytes.isBitSet(member.synergyAbility04Offset, member.synergyAbility04Bit),
        synergyAbility05 = bytes.isBitSet(member.synergyAbility05Offset, member.synergyAbility05Bit),
        synergyAbility06 = bytes.isBitSet(member.synergyAbility06Offset, member.synergyAbility06Bit),
        weaponMaterias = weaponMaterias,
        armorMaterias = armorMaterias,
    )
}

