import { customRender as render } from '../../utils/test-helper';
import LoadingPage from "./LoadingPage"
import { describe, expect, it } from 'vitest';

describe('Loading Page', () => {
    it('Loading Page should load properly - snapshot', async () => {
        const {container}  = render(<LoadingPage />);
        expect(container).toMatchSnapshot();
    });
})