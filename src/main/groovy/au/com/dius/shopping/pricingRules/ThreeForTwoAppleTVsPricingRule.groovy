package au.com.dius.shopping.pricingRules

import au.com.dius.shopping.Item

class ThreeForTwoAppleTVsPricingRule extends AbstractPricingRule {

    boolean isValid() {
        true
    }

    void applyRule(List<Item> items) {
        List<Item> appleTVItems = items.findAll { it.product.isAppleTV() }

        if (appleTVItems && appleTVItems.size() >= 3) {
            int freeAppleTVsAmount = (int)(appleTVItems.size()) / 3
            appleTVItems.eachWithIndex{ Item item, int i ->
                if (i < freeAppleTVsAmount) {
                    item.price = 0.00
                }
            }
        }
    }
}
