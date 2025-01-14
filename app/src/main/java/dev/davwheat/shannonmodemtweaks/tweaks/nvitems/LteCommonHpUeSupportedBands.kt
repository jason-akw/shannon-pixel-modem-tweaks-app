package dev.davwheat.shannonmodemtweaks.tweaks.nvitems

import android.os.Parcelable
import dev.davwheat.shannonmodemtweaks.utils.toNvItemHexString
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class LteCommonHpUeSupportedBands : NvItemTweak(), Parcelable {
  @IgnoredOnParcel
  override val name = "Enable HPUE PC2 on LTE"

  @IgnoredOnParcel
  override val description = "Enables HPUE power class 2 for B38/41"

  private val bands get() = listOf(38, 41)

  override val nvItems: List<NvItem>
    get() =
      bands.flatMapIndexed { index, band ->
        listOf(
          NvItem(
            id = "!LTE.COMMON.HPUE.SUPPORTED_BANDS",
            index = index,
            value = band.toNvItemHexString(2)
          )
        )
      } + NvItem(
        id = "!LTE.COMMON.HPUE.SUPPORTED_BANDS_NUM",
        value = bands.size.toNvItemHexString(1)
      )
}
