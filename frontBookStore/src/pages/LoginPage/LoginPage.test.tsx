import { customRender as render } from '../../utils/test-helper';
import LoginPage from "./LoginPage"
import { describe, expect, it } from 'vitest';

describe('Login Page', () => {
    it('Login Page should load properly - snapshot', async () => {
        const {container}  = render(<LoginPage />);
        expect(container).toMatchSnapshot();
    });
})