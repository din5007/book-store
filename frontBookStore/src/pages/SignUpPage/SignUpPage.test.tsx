import { customRender as render } from '../../utils/test-helper';
import SignUpPage from "./SignUpPage"
import { describe, expect, it } from 'vitest';

describe('Order Summary Page', () => {
    it('Order Summary Page should load properly - snapshot', async () => {
        const {container}  = render(<SignUpPage />);
        expect(container).toMatchSnapshot();
    });
})