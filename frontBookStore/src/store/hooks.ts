import { createTypedHooks } from "easy-peasy";

import { AppStoreModel } from ".";

export const { useStoreActions, useStoreState } = createTypedHooks<AppStoreModel>();