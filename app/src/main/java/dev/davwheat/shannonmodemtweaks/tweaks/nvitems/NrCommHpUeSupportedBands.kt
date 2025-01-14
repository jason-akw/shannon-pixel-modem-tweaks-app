package dev.davwheat.shannonmodemtweaks.tweaks.nvitems

import android.os.Parcelable
import dev.davwheat.shannonmodemtweaks.utils.toNvItemHexString
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class NrCommHpUePc1Dot5SupportedBands : NvItemTweak(), Parcelable {
  @IgnoredOnParcel
  override val name = "Enable HPUE PC2 on NR"

  @IgnoredOnParcel
  override val description = "Enables HPUE power class 2 for n38/40/41/77/78, n40 HPUE only available on Pixel 9 series."

  private val bands get() = listOf(38, 40, 41, 77, 78)

  override val nvItems: List<NvItem>
    get() =
      bands.flatMapIndexed { index, band ->
        listOf(
          NvItem(
            id = "!NRCOMM_HPUE_SUPPORTED_BANDS",
            index = index,
            value = band.toNvItemHexString(2)
          )
        )
      } + NvItem(
        id = "!NRCOMM_HPUE_SUPPORTED_BANDS_NUM",
        value = bands.size.toNvItemHexString(1)
      )
}
